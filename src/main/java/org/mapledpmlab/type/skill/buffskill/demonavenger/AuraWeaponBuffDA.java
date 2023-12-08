package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.common.AuraWeaponDot;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

import java.sql.Timestamp;

@Getter
@Setter
public class AuraWeaponBuffDA extends GaugeBuffSkill {

    private Timestamp endTime = new Timestamp(-1);

    public AuraWeaponBuffDA() {
        this.setName("오라 웨폰");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(720L);
        this.setDuration(140L);
        this.setBuffFinalDamage(1.06);
        this.setBuffIgnoreDefense(16L);
        this.setGaugePer(-10L);
        this.setRelatedSkill(new AuraWeaponDot());
    }
}
