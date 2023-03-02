async  function fetch(){

   const url = ('http://localhost:56397/api/tourists');

   try {
       let res = await fetch(url);
       console.log(res)
       return await res.json();
   } catch (error){
       console.log(error)
   }

fetch();

}