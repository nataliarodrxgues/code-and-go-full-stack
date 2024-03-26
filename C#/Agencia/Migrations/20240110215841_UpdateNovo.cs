using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Agencia.Migrations
{
    /// <inheritdoc />
    public partial class UpdateNovo : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.UpdateData(
                table: "agencia",
                keyColumn: "id",
                keyValue: 2,
                column: "destino",
                value: "Minas Gerais - MG");

            migrationBuilder.UpdateData(
                table: "agencia",
                keyColumn: "id",
                keyValue: 3,
                column: "destino",
                value: "Rio de Janeiro - RJ");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.UpdateData(
                table: "agencia",
                keyColumn: "id",
                keyValue: 2,
                column: "destino",
                value: "Minas Gerais");

            migrationBuilder.UpdateData(
                table: "agencia",
                keyColumn: "id",
                keyValue: 3,
                column: "destino",
                value: "Rio de Janeiro");
        }
    }
}
