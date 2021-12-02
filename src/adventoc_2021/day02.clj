(ns adventoc-2021.day02
  (:require [clojure.string :as str]))

(def initial_location {:horizontal 0 :depth 0})

(defn navigate [location, instruction]
  (let [amount (Integer/parseInt ((str/split instruction #" ") 1))]
    (case ((str/split instruction #" ") 0)
      "forward" (assoc location :horizontal (+ (get location :horizontal) amount))
      "up" (assoc location :depth (- (get location :depth) amount))
      "down" (assoc location :depth (+ (get location :depth) amount)))))

(defn determine_location [instructions]
  (as-> instructions $
    (str/split-lines $)
    (reduce navigate initial_location $)))

(defn location_multiplied [location]
  (* (location :horizonal) (location :depth)))
