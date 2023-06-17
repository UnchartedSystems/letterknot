(ns letterknot.events
  (:require [re-pressed.core :as rp]
            [re-frame.core :as rf]))

(rf/reg-event-db
 :init-db
 (fn [_ _]
   {:puzzle []
    :test   "hello"}))

(rf/reg-event-db
 :test
 (fn [db [_ val]]
   (assoc db :test val)))

(rf/reg-sub
 :test
 (fn [db _]
   (:test db)))


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
