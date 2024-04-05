package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.hoyoung.FistMethodDoomingLightBuff;

public class FistMethodDoomingLight extends AttackSkill {
    public FistMethodDoomingLight() {
        this.setName("권술 : 미생강변");
        this.setDamage(450.0 + 404);
        this.setAttackCount(8L);
        this.setAddDamage(20L);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(720L);
        this.setRelatedSkill(new FistMethodDoomingLightBuff());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
