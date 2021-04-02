(ns knossos.model.cas-test
  (:require [knossos.model :as model])
  (:require [clojure.test :refer :all]))

(deftest cas_register_simple_test
  (let [result
        (reduce model/step (model/cas-register)
                [{:process 0, :type :invoke, :f :read, :value nil}
                 {:process 1, :type :invoke, :f :write, :value 3}
                 {:process 1, :type :info, :f :write, :value 3}
                 {:process 0, :type :ok, :f :cas, :value [3 -1]}])]
    (is (:value result) -1)
    ))
