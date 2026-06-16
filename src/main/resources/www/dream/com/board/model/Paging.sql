select *
  from (
	   select rownum rn, id, title
		 from T_Reply
 		where rownum <= 20
 		order by id desc)
  where rn > 10;
  