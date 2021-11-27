INSERT INTO `role` (`id`, `role_name`) VALUES ('1', 'Admin');
INSERT INTO `role` (`id`, `role_name`) VALUES ('2', 'Collection_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('3', 'Paying_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('4', 'Store_Keeper');
INSERT INTO `role` (`id`, `role_name`) VALUES ('5', 'Finance_Officer');
INSERT INTO `role` (`id`, `role_name`) VALUES ('6', 'Manager');

INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('1', '100000', 'Colombo', '25000', '75000', '50000', '1000');
INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('2', '200000', 'Galle', '50000', '80000', '20000', '2000');
INSERT INTO `branch` (`id`, `maximum_capacity`, `address`, `bank_account_amount`, `monthly_expected_stock`, `stock`, `total_monthly_paddy_limit_per_farmer`) VALUES ('3', '200000', 'Head', '50000', '80000', '20000', '2000');

INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('1', 'Admin 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'admin11', '1', '1');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('2', 'Collection officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'col1', '1', '2');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('3', 'Paying officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'pay1', '1', '3');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('4', 'Store keeper 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'store1', '1', '4');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('5', 'Finance officer 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'finance1', '1', '5');
INSERT INTO `employee` (`id`, `name`, `password`, `user_name`, `branch_id`, `role_id`) VALUES ('6', 'Manager 01', '$2a$12$HbxRyta0B47JtF1e7gYM8egs7Jt2dwDwm2cdvLkceH3XSL23Xyho.', 'manager1', '1', '6');

INSERT INTO `paddy_price` (`id`, `buying_price`, `date`, `selling_price`) VALUES ('1', '30', '23-11-2021', '35');
INSERT INTO `paddy_price` (`id`, `buying_price`, `date`, `selling_price`) VALUES ('2', '31', '24-11-2021', '38');

INSERT INTO `farmer` (`id`, `name`, `registration_number`, `total_monthly_paddy_amount`) VALUES ('1', 'Vinod Lakshan', '00000001', '20');
INSERT INTO `farmer` (`id`, `name`, `registration_number`, `total_monthly_paddy_amount`) VALUES ('2', 'Testy Test', '00000002', '10');