declare variable $groupSizeString external;
declare variable $filiere external;
declare variable $niveau external;
declare variable $allStudents := doc(fn:concat("../../OUTPUT/Students/XMLFiles/","Students_",$filiere,$niveau,".xml"))//student;
declare variable $groupNumberString external;

declare variable $groupNumber := xs:integer($groupNumberString);
declare variable $groupSize := xs:integer($groupSizeString);


element { fn:concat("Student_",$filiere,$niveau,"_GroupeTP_",$groupNumber) }
{
    for $studentNumero in (($groupNumber - 1)*$groupSize + 1 to fn:min(($groupNumber*$groupSize,fn:count($allStudents))))
    return
      $allStudents[$studentNumero]
}
