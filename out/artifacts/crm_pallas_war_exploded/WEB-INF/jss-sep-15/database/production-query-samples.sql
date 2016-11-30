
use salesdept;

# select * from items;

# select SIN(pi()/4) as firstColumn, 1/3 as second, cos(pi());
-- comment
/*

*/

# select CURRENT_DATE, user();

# select * from machines where (model like 'GM-%') or (comment is null);

set SQL_SAFE_UPDATES = 0;

update products 
	set description = "unknown"
    where description = '';
    -- where id = 10;
    
select * from products;
    
set SQL_SAFE_UPDATES = 1;

