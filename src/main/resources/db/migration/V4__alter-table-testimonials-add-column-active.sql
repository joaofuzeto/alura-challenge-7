alter table testimonials add active tinyint;
update testimonials set active = 1;