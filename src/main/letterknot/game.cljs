(ns letterknot.game
  (:require [reagent.core :as r]
            [re-frame.core :as rf]
))

;https://clojureverse.org/t/capturing-key-presses-in-clojurescript-with-closure/6731

(defn word []
  [:div
   [:h1 "Testing!"]
   [:input {:type "button"
            :value @(rf/subscribe [:test])
            :on-click #(rf/dispatch [:test])
            :class "w-24"}]
   ])


(defn main []
  [:div
   [word]])
