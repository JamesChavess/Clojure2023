(ns invoice-item)

(defn- discount-factor [{:invoice-item/keys [discount-rate]
                         :or                {discount-rate 0}}]
  (- 1 (/ discount-rate 100.0)))
;; this beautiful function checks if there is a discount rate and then subtracts the discount rate divided to 100.00 to gte percentage

(defn subtotal
  [{:invoice-item/keys [precise-quantity precise-price discount-rate]
    :as                item
    :or                {discount-rate 0}}]
  (* precise-price precise-quantity (discount-factor item)))

;;this function receives quinatity price and discount as item and multiplies the price by quinaty and result of discpount factor passing item

