<?xml version="1.0" encoding='UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html><xsl:apply-templates /></html>
    </xsl:template>

    <xsl:template match='ListaAgendaTelefonica'>
        <head>
            <title>Agenda Telefónica</title>
        </head>
        <body>
            <h1>Agenda Telefónica</h1>
            <table border='1'>
                <tr>
                    <th>Nombre</th>
                    <th>Número</th>
                    <th>Dirección</th>
                    <th>Cod Postal</th>
                    <th>¿Es deudor?</th>
                    <th>¿Está borrado?</th>
                    <th>Fecha Nacimiento</th>
                    <th>Deuda</th>
                    <xsl:apply-templates select='DatosPersona'/>
                </tr>
            </table>
        </body>
    </xsl:template>

    <xsl:template match="DatosPersona">
        <tr><xsl:apply-templates /></tr>
    </xsl:template>

    <xsl:template match="name|phoneNumber|address|postalCode|debtor|deleted|birthday|debt">
        <td><xsl:apply-templates /></td>
    </xsl:template>

</xsl:stylesheet>