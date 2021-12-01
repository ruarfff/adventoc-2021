(ns adventoc-2021.day01
  (:require [clojure.string :as str]))

(defn- read-numbers [input]
  (as-> input $
    (str/split-lines $)
    (map #(Integer/parseInt %) $)))



(defn counter [val, num]
  (if (> num (val 0))
    [num (+ 1 (val 1))]
    [num (val 1)]))

(defn count_increments [numbers]
  (max 0 ((reduce counter [0 -1] numbers) 1)))



(defn sonar_sweep
  "Day 1 part 1"
  [input]
  (as-> input $
    (read-numbers $)
    (count_increments $)))



(defn sonar_sweep_sliding
  "Day 1 part 2"
  [input]
  (as-> input $
    (read-numbers $)
    (map (partial apply +) (partition 3 1 $))
    (count_increments $)))
