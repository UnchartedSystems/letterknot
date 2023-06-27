(ns letterknot.events
  (:require [re-pressed.core :as rp]
            [re-frame.core :as rf]))

;; https://day8.github.io/re-frame/EffectfulHandlers/

; db structure
#_{:puzzle [[4 \P] [2 0] [1 \N] [3 4] [0 \F] [1 2] [3 \C]]
   :words {:w0 {:l0 \S
                :l1 \H
                :l2 \A
                :l3 \R
                :l4 \P}
           :w1 {:l0 \S
                :l1 \N
                :l2 \A
                :l3 nil
                :l4 nil}}}

(rf/reg-event-db
 :init-db
 (fn [_ _]
   {:puzzle []
    :test   "hello"
    :words {:w0 {:l0 \S
                :l1 \H
                :l2 \A
                :l3 \R
                :l4 \P}
           :w1 {:l0 \S
                :l1 \N
                :l2 \A
                :l3 \P
                :l4 \S}}}))

(rf/reg-event-db
 :test
 (fn [db _]
   (let [db-val (:test db)]
     (assoc db :test (str db-val db-val)))))

(rf/reg-event-db
 :change-word
 (fn [db [_ row word]]
   (let [word-map {:l0 (nth word 0)
                   :l1 (nth word 1)
                   :l2 (nth word 2)
                   :l3 (nth word 3)
                   :l4 (nth word 4)}]
   (assoc-in db [:words row] word-map))))

(rf/reg-sub
 :test
 (fn [db _]
   (:test db)))

(rf/reg-sub
 :word
 (fn [db [_ i]]
   (i (:words db))))

(rf/dispatch
 [::rp/set-keydown-rules
  {:event-keys [[[:test]
                 [{:keyCode 13}]]]}])

#_(re-frame/dispatch
 [::rp/set-keydown-rules
  {;; takes a collection of events followed by key combos that can trigger the event
   :event-keys [
                ;; Event & key combos 1
                [;; this event
                 [:some-event-id1]
                 ;; will be triggered if
                 ;; enter
                 [{:keyCode 13}]
                 ;; or delete
                 [{:keyCode 46}]]
                ;; is pressed

                ;; Event & key combos 2
                [;; this event
                 [:some-event-id2]
                 ;; will be triggered if
                 ;; tab is pressed twice in a row
                 [{:keyCode 9} {:keyCode 9}]
                 ]]

   ;; takes a collection of key combos that, if pressed, will clear
   ;; the recorded keys
   :clear-keys
   ;; will clear the previously recorded keys if
   [;; escape
    [{:keyCode 27}]
    ;; or Ctrl+g
    [{:keyCode   71
      :ctrlKey true}]]
   ;; is pressed

   ;; takes a collection of keys that will always be recorded
   ;; (regardless if the user is typing in an input, select, or textarea)
   :always-listen-keys
   ;; will always record if
   [;; enter
    {:keyCode 13}]
   ;; is pressed

   ;; takes a collection of keys that will prevent the default browser
   ;; action when any of those keys are pressed
   ;; (note: this is only available to keydown)
   :prevent-default-keys
   ;; will prevent the browser default action if
   [;; Ctrl+g
    {:keyCode   71
      :ctrlKey true}]
    ;; is pressed
   }])
