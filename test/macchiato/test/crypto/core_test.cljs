(ns macchiato.test.crypto.core-test
  (:require
    [macchiato.bcrypt :as bcrypt]
    [macchiato.scrypt :as scrypt]
    [cljs.test :refer-macros [async is are deftest testing use-fixtures]]))

(def secret "my secret")

(deftest test-bcrypt
  (is (bcrypt/check secret (bcrypt/encrypt secret)))
  (is (not (bcrypt/check secret (bcrypt/encrypt "some other secret"))))
  (is (not (bcrypt/check "some other secret" (bcrypt/encrypt secret)))))

(deftest test-bcrypt-async
  (async done
    (bcrypt/encrypt-async
      secret
      (fn [err result]
        (is (bcrypt/check secret result))
        (done))))
  (async done
    (bcrypt/check-async
      secret
      (bcrypt/encrypt secret)
      (fn [err result]
        (is result)
        (done)))))

(deftest test-scrypt
  (is (scrypt/check secret (scrypt/encrypt secret)))
  (is (not (scrypt/check secret (scrypt/encrypt "some other secret"))))
  (is (not (scrypt/check "some other secret" (scrypt/encrypt secret)))))

(deftest test-scrypt-async
  (async done
    (scrypt/encrypt-async
      secret
      scrypt/default-opts
      (fn [err result]
        (is (scrypt/check secret result))
        (done))))
  (async done
    (scrypt/check-async
      secret
      (scrypt/encrypt secret)
      (fn [err result]
        (is result)
        (done)))))
