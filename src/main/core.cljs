(ns core
  (:require [reagent.dom :as d]
            [reagent.core :as r]))
            

(defn header
 []
 [:div
  [:h1 "A template for reagent apps"]])

(defn counter
  []
  (let [count (r/atom 1)]
    (fn []
     [:div
      [:button.btn {:on-click (fn [_] (swap! count dec))} "-"]
      [:button {:on-click (fn [_] (println @count))} (str @count)]
      [:button.btn {:on-click (fn [_] (swap! count inc))} "+"]])))

(defn app []
  [:div
   [header]
   [counter]])

(defn ^:dev/after-load start
  []
  (d/render [app]
           (.getElementById js/document "root")))

(defn ^:export main
  []
  (start))
