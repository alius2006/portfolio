using System.Collections.Generic;
using System.Linq;
using backend.Domain;
using backend.Services;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers
{
    [Route("api/users")]
    [ApiController]
    public class UserEndpoints : ControllerBase
    {
        static Users userRepository = new MemoryUsers(); 
         
        Dictionary<int, Models.User> users => userRepository.Users;
         
        //GET api/users/1
        [HttpGet("{id}")]
        public ActionResult<Models.User> FindById(int id) => users.ContainsKey(id) ? new ActionResult<Models.User>(users[id]) : StatusCode(404);
 
        //GET api/users/search/jsmith
        [HttpGet("search/{name}")]
        public ActionResult<Models.User> SearchByName(string name) => users.Values.FirstOrDefault(user => user.Name.Equals(name));
         
        //POST api/users/1/updateCurrency/300
        [HttpPost("{id}/updateCurrency/{currencyValue}")]
        public void UpdateCurrency(int id, int currencyValue) => userRepository.SetCurrency(id, currencyValue);
         
        //PUT api/users/add
        [HttpPut("add")]
        public ActionResult<string> Add([FromBody] Models.AddUserRequest request) => userRepository.Add(request).Message;
         
        //DELETE api/users/1/delete
        [HttpDelete("{id}/delete")]
        public ActionResult Delete(int id) => StatusCode(userRepository.Delete(id));
    }
}