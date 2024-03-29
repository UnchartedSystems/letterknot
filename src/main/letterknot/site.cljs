(ns letterknot.site
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [re-pressed.core :as rp]
            [re-frame.core :as rf]
            [letterknot.game :as game]
            [letterknot.events :as events]
            ))
;; npx tailwindcss -i ./src/css/app.css -o ./public/app.css --watch

(defn frame [text]
  [:div.mx-5
   [:div {:class [:container :grid :place-content-center :mt-20 "max-w-[73ch]"]}
    text]])

(defn root-element []
  [:div
   #_[nav-bar]
    [frame [game/main]]
   #_[other stuff]
   ])

(defn ^:dev/after-load start []
  (rdom/render
   [:div {:class "bg-[#fff] w-full"} [root-element]]
   (.-body js/document)))

(defn init []
  (rf/dispatch-sync [:init-db])
  (rf/dispatch-sync [::rp/add-keyboard-event-listener "keydown"])
  (start))

(defn ^:dev/before-load stop []
  #_(js/console.log "stop"))


