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
        this.setCooldown(120.0);
        this.setDuration(94L);
        this.setBuffFinalDamage(1.06);
        this.setBuffIgnoreDefense(16L);
        this.setGaugePer(-10L);
        this.setApplyServerLag(true);
        this.setRelatedSkill(new AuraWeaponDot());
    }
}
