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


(defn letter [letter]
  #_[:div.w-12.h-12.border-solid letter]
  [:div {:class "w-12 h-12 border-solid flex items-center justify-center font-sans"} ;TODO: move font config
   [:h2 letter]])

(defn row []
  [:div {:class "grid grid-rows-1 grid-cols-5 max-w-fit"}
   [letter "H"]
   [letter "E"]
   [letter "L"]
   [letter "L"]
   [letter "O"]])

(defn main []
  [:div
   [row]])
