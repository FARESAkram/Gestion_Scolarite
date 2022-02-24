<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times">
    <xsl:template match="/student">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="29.7cm" page-width="21cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                    <fo:region-before extent="2cm"/>
                    <fo:region-after extent="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block-container text-align="center">
                        <fo:block  font-size="16px" space-after="5mm">UNIVERSITÉ ABDELMALED ESSAÂDI</fo:block>
                        <fo:block border="1px black solid" text-align="center" font-size="16px" space-before="1cm" space-after="1cm">ATTESTATION DE REUSSITE</fo:block>
                        <fo:block text-align="center" font-size="12px" space-before="1cm" space-after="1cm">Le Directeur de l'Ecole Nationale dees Sciences Appliquées de Tanger atteste que</fo:block>
                        <fo:block white-space="pre" text-align="center" font-weight="bold" font-size="12px" space-before="1cm" space-after="1cm">Monsieur <xsl:value-of select="concat(firstName,' ',lastName)"/></fo:block>
                        <fo:block text-align="center"  font-size="12px" space-before="1cm" space-after="1cm">
                            né le <xsl:value-of select="dateOfBirth"/>
                        </fo:block>
                        <fo:block text-align="center"  font-size="12px" space-before="1cm" space-after="1cm">
                            a été déclaré admis au niveau
                        </fo:block>
                        <fo:block text-align="center" font-weight="bold"  font-size="12px" space-before="1cm" >
                            <xsl:value-of select="className"/>
                        </fo:block>
                        <fo:block border-bottom-width="1px" width="5cm" border-bottom-style="solid" space-after="11cm" margin-top="7mm"/>
                        <fo:block text-align="right">Fait à Tanger le <xsl:value-of  select="format-date(current-date(), '[M01]/[D01]/[Y0001]')"/></fo:block>
                        <fo:block text-align="left">
                            <fo:block space-before="0.4cm" space-after="0.5cm">Directeur</fo:block>
                            <fo:block font-size="9px">Avis important: il ne peut être dêlivré qu'un seul exemplaire de cette attestation. Aucun duplicata ne sera fourni.</fo:block>
                        </fo:block>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>