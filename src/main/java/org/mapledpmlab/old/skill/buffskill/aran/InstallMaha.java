package org.mapledpmlab.old.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class InstallMaha extends BuffSkill {
    public InstallMaha() {
        this.setName("인스톨 마하");
        this.setDelay(960L);
        this.setDuration(40L + 10);         // 코어 강화
        this.addBuffAttMagicPer(35L);
        this.addBuffFinalDamage(1.05);      // 코어 강화
        this.setCooldown(90.0);
    }
}
