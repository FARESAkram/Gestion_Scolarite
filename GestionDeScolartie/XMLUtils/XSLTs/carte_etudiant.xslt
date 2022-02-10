<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times"
>

    <xsl:template match="/student">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="carte" page-height="5.4cm" page-width="8.5cm" margin-top="2.5mm" margin-bottom="5mm" margin-left="5mm" margin-right="5mm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="carte">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:block>
                        <fo:table height="1cm" width="100%">
                            <fo:table-column
                                             column-width="10%"/>
                            <fo:table-column
                                             column-width="80%"/>
                            <fo:table-column
                                             column-width="10%"/>
                            <fo:table-body>
                                <fo:table-cell column-number="1" text-align="right">
                                    <fo:block>
                                        <fo:external-graphic height="0.1cm" width="1cm" content-height="1cm"
                                                         content-width="1cm" src="url('Base_de_donnée/Students/images/uae.png')"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell column-number="2"  >
                                    <fo:block-container space-before="1cm" width="100%" font-size="7px" text-align="center" color="#28a9e0">
                                        <fo:block>Université Abdelmaled Essadi</fo:block>
                                        <fo:block>Ecole national des sciences appliquées de Tanger</fo:block>
                                    </fo:block-container>
                                </fo:table-cell>
                                <fo:table-cell text-align="left" column-number="3">
                                    <fo:block>
                                        <fo:external-graphic height="0.1cm" width="1cm" content-height="1cm"
                                                         content-width="1cm" src="url('Base_de_donnée/Students/images/ensat.jpg')"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-body>
                        </fo:table>
                    </fo:block>
                    <fo:block border-bottom-width="1px" width="5cm" border-bottom-style="solid" border-color="#e08128" margin-top="7mm"/>
                    <fo:block space-before="0.2cm" font-size="9px" text-align="center" color="#28a9e0">Carte D'Etudiant</fo:block>
                    <fo:table height="1cm" space-before="0.5cm" width="100%">
                        <fo:table-column
                                column-width="25%"/>
                        <fo:table-column
                                column-width="50%"/>
                        <fo:table-column
                                column-width="25%"/>
                        <fo:table-body>
                            <fo:table-cell column-number="1">
                                <fo:block>
                                    <fo:block> <fo:external-graphic height="2cm" width="1.5cm" content-height="2cm"
                                        content-width="1.5cm" src="url({photo})"/></fo:block>
                                </fo:block>
                            </fo:table-cell>
                            <fo:table-cell display-align="center" column-number="2"  >
                                <fo:block-container space-before="0.5cm" font-size="9px" text-align="left" color="#28a9e0">
                                    <fo:block> <xsl:value-of select="firstName"/> </fo:block>
                                    <fo:block> <xsl:value-of select="lastName"/> </fo:block>
                                    <fo:block> <xsl:value-of select="@CNE"/> </fo:block>
                                </fo:block-container>
                            </fo:table-cell>
                            <fo:table-cell text-align="left" column-number="3">
                                <fo:block space-start="4cm">
                                    <fo:external-graphic height="2cm" width="2cm" content-height="2cm"
                                                         content-width="2cm" src="url('Base_de_donnée/Students/images/qrcode.png')"/>
                                </fo:block>
                            </fo:table-cell>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>