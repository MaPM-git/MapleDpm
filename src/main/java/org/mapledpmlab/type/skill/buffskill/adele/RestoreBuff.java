package org.mapledpmlab.type.skill.buffskill.adele;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.adele.Restore;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RestoreBuff extends BuffSkill {
    public RestoreBuff() {
        this.setName("리스토어");
        this.setCooldown(180.0);
        this.setDelay(720L);
        this.setDuration(45L);
        this.setBuffFinalDamage(1.1);
        this.setRelatedSkill(new Restore());
    }
}
