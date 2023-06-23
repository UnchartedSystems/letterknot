(ns letterknot.game
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
))

;https://clojureverse.org/t/capturing-key-presses-in-clojurescript-with-closure/6731

#_(defn word []
  [:div
   [:h1 "Testing!"]
   [:input {:type "button"
            :value @(rf/subscribe [:test])
            :on-click #(rf/dispatch [:test])
            :class "w-24"}]
   ])


(defn letter [letter]
  #_[:div.w-12.h-12.border-solid letter]
  [:div {:class "w-12 h-12 border-solid flex items-center justify-center font-sans"} ;TODO: move font config
   [:h2 letter]])

(defn word-row [word-index]
  (let [word @(rf/subscribe [:word word-index])]
  [:div {:class "grid grid-rows-1 grid-cols-5 max-w-fit"}
   [letter (:l0 word)]
   [letter (:l1 word)]
   [letter (:l2 word)]
   [letter (:l3 word)]
   [letter (:l4 word)]]))

(defn main []
  [:div
   [word-row :w0]])
