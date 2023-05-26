(ns letterknot.game
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))



(defn word []
  [:div
   [:h1 "Testing!"]
   [:input {:type "text" :maxlength 5 :class "w-24"}]
   ])


(defn main []
  [:div
   [word]])

;; function writeAtLast() {
;;             var textbox = document.getElementById('text');
;;             textbox.setSelectionRange(textbox.value.length, textbox.value.length);
;;         }

;; <input id="text" type="text" class="txtbox" onkeypress='writeAtLast()' onCopy="return false" onDrag="return false" onDrop="return false" onPaste="writeAtLast()" autocomplete=off />
