using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

#pragma warning disable CA1814 // Prefer jagged arrays over multidimensional

namespace Agencia.Migrations
{
    /// <inheritdoc />
    public partial class Firstmigration : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AlterDatabase()
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.CreateTable(
                name: "agencia",
                columns: table => new
                {
                    id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn),
                    nome = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    destino = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    agencia_url = table.Column<string>(type: "longtext", nullable: false)
                        .Annotation("MySql:CharSet", "utf8mb4"),
                    preco = table.Column<decimal>(type: "decimal(65,30)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_agencia", x => x.id);
                })
                .Annotation("MySql:CharSet", "utf8mb4");

            migrationBuilder.InsertData(
                table: "agencia",
                columns: new[] { "id", "agencia_url", "destino", "nome", "preco" },
                values: new object[,]
                {
                    { 1, "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_juntos.jpg", "Praias", "Pacote: Alegria Compartilhada", 3.250m },
                    { 2, "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_casal.jpg", "Minas Gerais", "Pacote: Tour do Amor", 3.390m },
                    { 3, "https://github.com/nataliarodrxgues/code-and-go-viagens/blob/main/IMG/promo_carnaval.jpg", "Rio de Janeiro", "Pacote: A Folia que Você Merece!", 4.150m }
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "agencia");
        }
    }
}
