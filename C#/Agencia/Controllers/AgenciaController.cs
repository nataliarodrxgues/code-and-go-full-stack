using Agencia.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;


namespace Agencia.Controllers
{
    [ApiController]
    [Route("api/findagencia")]
    public class AgenciaController : ControllerBase
    {

        private readonly DataContext _dataContext;

        public AgenciaController(DataContext dataContext)
        {
            _dataContext = dataContext;
        }

        [HttpGet]

        public async Task<ActionResult<IEnumerable<Agencia.Model.AgenciaModel>>> GetViagens()
        {
            return await _dataContext.Agencias.ToListAsync();
        }
    }


    } 
