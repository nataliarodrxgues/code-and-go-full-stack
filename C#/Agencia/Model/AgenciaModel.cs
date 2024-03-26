using System.ComponentModel.DataAnnotations.Schema;

namespace Agencia.Model
{
    [Table("agencia")]

    public class AgenciaModel
    {
        [Column("id")]
        public int Id { get; set; }

        [Column("nome")]
        public string Nome { get; set; } = string.Empty;

        [Column("destino")]
        public string Destino { get; set; } = string.Empty;

        [Column("agencia_url")]
        public string AgenciaURL { get; set; } = string.Empty;


        [Column("preco")]
        public decimal Preco { get; set; }
    }
}
