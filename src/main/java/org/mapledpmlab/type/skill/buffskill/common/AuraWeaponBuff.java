package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AuraWeaponBuff extends BuffSkill {
    public AuraWeaponBuff() {
        this.setName("오라 웨폰");
        this.setCooldown(0.0);  // 스택형이라 딜사이클에서 따로 처리
        this.setDelay(720L);
        this.setDuration(140L);
        this.setBuffFinalDamage(1.06);
        this.setBuffIgnoreDefense(16L);
    }
}
