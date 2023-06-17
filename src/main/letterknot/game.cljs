(ns letterknot.game
  (:require [reagent.core :as r]
            [re-pressed.core :as rp]
            [re-frame.core :as rf]
            [reagent.dom :as rdom]))

;https://clojureverse.org/t/capturing-key-presses-in-clojurescript-with-closure/6731

(defn word []
  (let [db-val @(rf/subscribe [:test])]
  [:div
   [:h1 "Testing!"]
   [:input {:type "button"
            :value db-val
            :on-click #(rf/dispatch [:test (str db-val db-val)])
            :class "w-24"}]
   ]))


(defn main []
  [:div
   [word]])
