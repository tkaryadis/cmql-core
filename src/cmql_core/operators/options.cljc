(ns cmql-core.operators.options
  (:require [cmql-core.internal.convert.stages :refer [cmql-vector->cmql-map]]))

(defn remove-o []
  {:remove  true})

(defn new-o []
  {:new true})

(defn fields-o [& fields]
  (let [m (cmql-vector->cmql-map fields 0)]
    {:fields m}))

(defn allow-disk-use []
  {:allowDiskUse true})

(defn upsert [v]
  {"upsert" v})

;;-----------------------------------my key options---------------------------------------------------------------------

;;Those will not be part of command,so i have to manually add them as command options(else would look like addFields)
;;i add them in command-keys (convert:445)

(defn command []
  {:command ""})

(defn explain
  ([]
   {:explain "queryPlanner"})
  ([verbosity]
   {:explain verbosity}))

(defn array-filters [& filters]
  {:arrayFilters (into [] filters)})

(defn path [& filters]
  {:arrayFilters (into [] filters)})