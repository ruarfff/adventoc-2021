(ns adventoc-2021.day02
  (:require [clojure.string :as str]))

(def initial_location {:horizontal 0 :depth 0})

(def initial_location_aim {:horizontal 0 :depth 0 :aim 0})

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

(defn navigate_aim [location, instruction]
  (let [amount (Integer/parseInt ((str/split instruction #" ") 1))]
    (case ((str/split instruction #" ") 0)
      "forward" (assoc (assoc location :horizontal (+ (get location :horizontal) amount)) :depth (+ (get location :depth) (* (get location :aim) amount)))
      "up" (assoc location :aim (- (get location :aim) amount))
      "down" (assoc location :aim (+ (get location :aim) amount)))))

(defn determine_location_aim [instructions]
  (as-> instructions $
    (str/split-lines $)
    (reduce navigate_aim initial_location_aim $)))
