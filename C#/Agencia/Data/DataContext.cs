using Agencia.Model;
using Microsoft.EntityFrameworkCore;

namespace Agencia.Data
{
  public class DataContext : DbContext
  {
    public DataContext(DbContextOptions<DataContext> options) : base(options)
    {
    }

    public DbSet<AgenciaModel> Agencias { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
      // Chamar a implementação da classe base, se necessário
      base.OnModelCreating(modelBuilder);
      // Configurações do modelo aqui

      modelBuilder.Entity<AgenciaModel>().HasData(
          new AgenciaModel
          {
            Id = 1,
            Nome = "Pacote: Alegria Compartilhada",
            Destino = "Praias",
            AgenciaURL = "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_juntos.jpg",
            Preco = 3.250M
          },

          new AgenciaModel
          {
            Id = 2,
            Nome = "Pacote: Tour do Amor",
            Destino = "Minas Gerais - MG",
            AgenciaURL = "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_casal.jpg",
            Preco = 3.390M
          },

          new AgenciaModel
          {
            Id = 3,
            Nome = "Pacote: A Folia que Você Merece!",
            Destino = "Rio de Janeiro - RJ",
            AgenciaURL = "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_carnaval.jpg",
            Preco = 4.150M
          }
      );
    }
  }
}
