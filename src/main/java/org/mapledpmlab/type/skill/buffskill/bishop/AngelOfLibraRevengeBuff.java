package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AngelOfLibraRevengeBuff extends BuffSkill {
    public AngelOfLibraRevengeBuff() {
        this.setName("엔젤 오브 리브라(복수의 천사/버프)");
        this.setBuffFinalDamage(1.1);
    }
}
