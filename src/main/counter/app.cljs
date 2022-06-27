(ns counter.app
  (:require [reagent.core :as r]
            [reagent.dom :as dom]))

(println "Code Reloaded:")

(defonce current-count (r/atom 0))

(defn application []
  [:div @current-count " "
   [:button {:onClick #(swap! current-count inc)} " + "]
   [:button {:onClick #(swap! current-count dec)} " - "]])

(dom/render [application] (js/document.getElementById "app"))


(defn init []
  (println "Initialization Complete!"))
