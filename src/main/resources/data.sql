INSERT INTO `role` (`id`, `role_name`) VALUES ('1', 'Admin');
INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('1', '100', 'colombo', '25000', '1000', '20', '10');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('1', 'test', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'test', '1', '1');