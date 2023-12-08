package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.common.OtherWorldVoid;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class OtherWorldGoddessBlessingDA extends GaugeBuffSkill {
    public OtherWorldGoddessBlessingDA() {
        this.setName("이계 여신의 축복");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(630L);
        this.setDuration(40L);
        this.addBuffFinalDamage(1.11);
        this.setGaugePer(-5L);
        this.setRelatedSkill(new OtherWorldVoid());
    }
}
