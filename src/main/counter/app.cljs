(ns counter.app
  (:require [reagent.core :as r]
            [reagent.dom :as dom]))

(println "Code Reloaded:")

(defonce counters (r/atom []))

(defn add-counter [i]
  (let [to-zero     (fn [& _] 0)
        vec-delete  (fn [v i] (into (subvec v 0 i) (subvec v (inc i))))]
    [:div {:key (str i)} (str (get @counters i))
     [:button {:onClick #(swap! counters update i inc)} " +1 "]
     [:button {:onClick #(swap! counters update i dec)} " -1 "]
     [:button {:onClick #(swap! counters update i to-zero)} " Reset "]
     [:button {:onClick #(swap! counters vec-delete i)} " X "]]))

(defn application []
  [:div
   [:h1 "Counter"]
   [:button {:onClick #(swap! counters conj 0)} "New Counter"]
   (doall (map add-counter (range (count @counters))))])

(dom/render [application] (js/document.getElementById "app"))


(defn init []
  (println "Initialization Complete!"))
