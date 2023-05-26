(ns letterknot.site
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]
            [letterknot.game :as game]
            ))
;; npx tailwindcss -i ./src/css/app.css -o ./public/app.css --watch

(defn root-element []
  [:div.mx-5.my-5
   [:div #_{:class [:container "max-w-[73ch]"]}
    [game/main]]])

(defn ^:dev/after-load start []
  (rdom/render
   [:div {:class "bg-[#fff] w-full"} [root-element]]
   (.-body js/document)))

(defn init []
  (start))

(defn ^:dev/before-load stop []
  #_(js/console.log "stop"))
