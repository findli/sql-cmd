# call insertOrder(...);

#####################
# 1) JOIN vs subquery
#####################

# OK
select model, fkItem, fkProd from machines inner join productivity on productivity.fkMachine = machines.id 
	where fkItem = 5;

# Wrong
select model, fkItem, fkProd from machines, productivity 
	where productivity.fkMachine = machines.id && fkItem = 5;

# SubQuery?

# Wrong: 1) 1row needed -> limit, aggregate functions
#        2) may be 0 rows  ->  not use "=" -> subquery operators
select * from machines where machines.id = (select fkMachine from Productivity where fkItem = 5 limit 1);

select fkMachine from Productivity where fkItem = 300 order by fkMachine limit 1;
    
# Syntax OK, but use join instead
select * from machines where machines.id IN (select fkMachine from Productivity where fkItem = 5);

# OK
select machines.model from machines inner join productivity on productivity.fkMachine = machines.id 
	where productivity.fkItem = 5;
    
    
# subquery is ok
select machines.model, productivity.fkItem 
	from  machines inner join productivity on productivity.fkMachine = machines.id 
    where machines.id IN (select machines.id from machines inner join productivity on productivity.fkMachine = machines.id
							where itemsPerHour = (select max(itemsPerHour) from productivity));

select fkMachine from productivity
	where itemsPerHour = (select max(itemsPerHour) from productivity);
   
   
select * from  machines  where  
	comment = (select count(*) from productivity where productivity.fkMachine = machines.id );


    
#####################
# 2) Grouping
#####################

# grouping in select 
#  uses aggreagate functions : MIN, MIN, COUNT, SUMM, AVG

select machines.model, materials.name, MAX(productivity.itemsperhour)
	from machines inner join productivity on productivity.fkMachine = machines.id 
				  inner join items on productivity.fkItem = items.id
				inner join materials on items.fkMaterial = materials.id
	where materials.name = 'Металл' && productivity.itemsperhour > 2    # before groupping
    group by machines.model
    having MAX(productivity.itemsperhour) > 4							# after groupping
	order by machines.model, materials.name;

# equivalent of
# select * from  machines  where  
#	comment = (select count(*) from productivity where productivity.fkMachine = machines.id );

select machines.model, machines.comment, count(productivity.id)
	from machines inner join productivity on productivity.fkMachine = machines.id 
	group by machines.model
    having machines.comment = count(productivity.id)			
	order by machines.model;

# Variables may hold only single value
set @var = (select max(productivity.itemsperhour) from productivity);



#####################
# 3) Subquery operators
#####################

# IN, EXISTS, ANY, ALL

# all machines which have at least one productivity record
select * from machines where EXISTS(select * from productivity where productivity.fkMachine = machines.id);
select * from machines where NOT EXISTS(select * from productivity where productivity.fkMachine = machines.id);
# equivalent
select * from machines where machines.id IN(select fkMachine from productivity);
select * from machines where machines.id NOT IN(select fkMachine from productivity);
# not quite equivalent : cannot perform as NOT EXISTS
select machines.model, count(productivity.id)
	from machines inner join productivity on productivity.fkMachine = machines.id 
	group by machines.model
    order by machines.model;

select * from machines;


# equivalent
#select * from machines where comment = ANY (SELECT ... )
#select * from machines where comment IN (SELECT ... )

select * from machines where comment > ALL 
			(SELECT count(*) from productivity 
					inner join items on productivity.fkItem = items.id
                    where items.fkMaterial = 1 );


# all machines which can produce metallic items
select machines.model, count(items.id)
	from machines inner join productivity on productivity.fkMachine = machines.id 
				  inner join items on productivity.fkItem = items.id
				inner join materials on items.fkMaterial = materials.id
	where materials.name = 'Металл' 
    group by machines.model
    having count(items.id) > 0							
	order by machines.model, materials.name;

# all machines which canNOT produce metallic items
select * from machines where id not in (
select machines.id
	from machines inner join productivity on productivity.fkMachine = machines.id 
				  inner join items on productivity.fkItem = items.id
				inner join materials on items.fkMaterial = materials.id
	where materials.name = 'Металл' 
    group by machines.model
    having count(items.id) > 0							
	order by machines.model, materials.name);


# check query
select DISTINCT machines.model, materials.name
	from machines inner join productivity on productivity.fkMachine = machines.id 
				  inner join items on productivity.fkItem = items.id
				inner join materials on items.fkMaterial = materials.id
	order by machines.model, materials.name;


