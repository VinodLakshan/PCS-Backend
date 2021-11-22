INSERT INTO `role` (`id`, `role_name`) VALUES ('1', 'Admin');
INSERT INTO `role` (`id`, `role_name`) VALUES ('2', 'Collection_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('3', 'Paying_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('4', 'Store_Keeper');
INSERT INTO `role` (`id`, `role_name`) VALUES ('5', 'Finance_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('6', 'Manager');

INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('1', '1000', 'Colombo', '25000', '500', '100', '10');
INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('2', '2000', 'Galle', '50000', '800', '200', '20');
INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('3', '2000', 'Head', '50000', '800', '200', '20');

INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('1', 'Admin 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'admin11', '1', '1');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('2', 'Collection officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'col1', '1', '2');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('3', 'Paying officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'pay1', '1', '3');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('4', 'Store keeper 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'store1', '1', '4');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('5', 'Finance officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'finance1', '1', '5');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('6', 'Manager 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'manager1', '1', '6');