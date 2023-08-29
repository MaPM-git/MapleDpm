package org.mapledpmlab.type.skill.buffskill.soulmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.soulmaster.AstralBlitz1;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AstralBlitzBuff extends BuffSkill {
    public AstralBlitzBuff() {
        this.setName("아스트랄 블리츠(버프)");
        this.addBuffFinalDamage(1.1);
        this.setDuration(20L);
        this.setRelatedSkill(new AstralBlitz1());
    }
}
