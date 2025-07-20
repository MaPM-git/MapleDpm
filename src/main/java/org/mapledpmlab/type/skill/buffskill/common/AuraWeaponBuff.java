package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.common.AuraWeaponDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

import java.sql.Timestamp;

@Getter
@Setter
public class AuraWeaponBuff extends BuffSkill {

    private Timestamp endTime = new Timestamp(-1);

    public AuraWeaponBuff() {
        this.setName("오라 웨폰");
        this.setCooldown(120.0);
        this.setDuration(94L);
        this.setBuffFinalDamage(1.06);
        this.setBuffIgnoreDefense(16L);
        this.setApplyServerLag(true);
        this.setRelatedSkill(new AuraWeaponDot());
    }
}
