package org.mapledpmlab.type.skill.buffskill.cannonshooter;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MonkeyFuriousBuff extends BuffSkill {
    public MonkeyFuriousBuff() {
        this.setName("몽키 퓨리어스");
        this.setDuration(60L);
        this.addBuffDamage(40L);
    }
}
