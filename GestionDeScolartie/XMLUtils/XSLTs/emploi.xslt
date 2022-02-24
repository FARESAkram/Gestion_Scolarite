<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo"
                xmlns:date="http://exslt.org/dates-and-times">
    <xsl:template match="/semaine">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="simpleA4" page-height="21cm" page-width="29.7cm" margin-top="2cm" margin-bottom="2cm" margin-left="2cm" margin-right="2cm">
                    <fo:region-body/>
                    <fo:region-before extent="2cm"/>
                    <fo:region-after extent="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="simpleA4">
                <fo:flow flow-name="xsl-region-body" >
                    <fo:table inline-progression-dimension="auto" table-layout="auto">
                        <fo:table-body>
                            <fo:table-row text-align="center" background-color="#bbccdd">
                                <fo:table-cell border-style="solid" border-width="0.2mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Lundi</fo:block></fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Mardi</fo:block></fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Mercredi</fo:block></fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Jeudi</fo:block></fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Vendredi</fo:block></fo:table-cell>
                                <fo:table-cell border-style="solid" border-width="0.2mm"><fo:block>Samedi</fo:block></fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>08:00</fo:block>
                                    <fo:block>08:30</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block/>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>09:00</fo:block>
                                    <fo:block>09:30</fo:block>
                                    <fo:block>10:00</fo:block>
                                    <fo:block>10:30</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='9:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='9:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='9:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 9h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='9:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 09h:00 - 10h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='9:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>11:00</fo:block>
                                    <fo:block>11:30</fo:block>
                                    <fo:block>12:00</fo:block>
                                    <fo:block>12:30</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='11:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='11:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='11:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='11:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 11h:00 - 12h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='11:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>12:30</fo:block>
                                    <fo:block>13:00</fo:block>
                                    <fo:block>13:30</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block />
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>14:00</fo:block>
                                    <fo:block>14:30</fo:block>
                                    <fo:block>15:00</fo:block>
                                    <fo:block>15:30</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='14:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='14:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='14:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='14:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='14:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='14:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='14:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='14:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='14:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='14:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='14:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='14:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='14:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='14:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='14:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='14:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='14:30']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:30 - 16:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='14:30']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:30 - 16h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='14:30']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:30 - 16h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='14:30']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:30 - 16h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='14:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='14:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='14:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='14:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='14:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 14h:00 - 15h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='14:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                            <fo:table-row text-align="center">
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm" background-color="#bbccdd">
                                    <fo:block>16:00</fo:block>
                                    <fo:block>16:30</fo:block>
                                    <fo:block>17:00</fo:block>
                                    <fo:block>17:30</fo:block>
                                    <fo:block>18:00</fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='16:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='16:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='16:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='16:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='lundi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='16:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='16:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='16:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mardi']/hour[@from='16:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mardi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='16:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='16:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='16:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='mercredi']/hour[@from='16:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='mercredi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='16:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='16:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='16:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='jeudi']/hour[@from='16:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='jeudi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='16:30']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:30 - 18h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='16:30']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16h:30 - 18h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='16:30']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:30 - 18h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='vendredi']/hour[@from='16:30']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:30 - 18h:00
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='vendredi']/hour[@from='16:30']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell border-right-style="solid" border-width="0.2mm" padding="1mm">
                                    <fo:block>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='16:00']/module/@type = 'EX'">
                                            <fo:block text-align="center" background-color="#00ff00" font-size="8px" space-before="1mm" space-after="1mm">
                                                EX 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='16:00']/module/@type = 'CM'">
                                            <fo:block text-align="center" background-color="#7798ed" font-size="8px" space-before="1mm" space-after="1mm">
                                                CM 16:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='lundi']/hour[@from='16:00']/module/@type = 'TD'">
                                            <fo:block text-align="center" background-color="#ffd202" font-size="8px" space-before="1mm" space-after="1mm">
                                                TD 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                        <xsl:if test="//jour[@nom='samedi']/hour[@from='16:00']/module/@type = 'TP'">
                                            <fo:block text-align="center" background-color="#e55763" font-size="8px" space-before="1mm" space-after="1mm">
                                                TP 16h:00 - 17h:30
                                            </fo:block>
                                            <fo:block text-align="center" font-size="7px" space-before="1mm" space-after="1mm">
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/nom" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/Professeur" />
                                                </fo:block>
                                                <fo:block>
                                                    <xsl:value-of select="//jour[@nom='samedi']/hour[@from='16:00']/module/salle" />
                                                </fo:block>
                                            </fo:block>
                                        </xsl:if>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>