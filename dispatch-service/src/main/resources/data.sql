-- Seed Medications
INSERT INTO medications (id, name, weight, code, image_url) VALUES (1, 'Paracetamol', 200, 'PCT_101', 'sample1.png');
INSERT INTO medications (id, name, weight, code, image_url) VALUES (2, 'Chloroquine', 200, 'CLR_101', 'sample2.png');
INSERT INTO medications (id, name, weight, code, image_url) VALUES (3, 'Laxative', 200, 'LAX_101', 'sample3.png');

-- Seed Drones
INSERT INTO drones (id, battery_capacity, serial_number, model, state, weight_limit) VALUES (1, 70.5,'MW10000001', 'MIDDLE_WEIGHT',  'IDLE', 60);
INSERT INTO drones (id, battery_capacity, serial_number, model, state, weight_limit) VALUES (2, 20.5,'MW10000002', 'LIGHT_WEIGHT',  'DELIVERING', 30);
INSERT INTO drones (id, battery_capacity, serial_number, model,  state, weight_limit) VALUES (3, 40.75,'MW10000003', 'CRUISER_WEIGHT',  'IDLE', 100);