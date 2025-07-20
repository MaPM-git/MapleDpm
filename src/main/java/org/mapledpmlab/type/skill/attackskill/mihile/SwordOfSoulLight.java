package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.mihile.SwordOfSoulLightBuff;

public class SwordOfSoulLight extends AttackSkill {
    public SwordOfSoulLight() {
        this.setName("소드 오브 소울 라이트(검의 잔상)");
        this.setAttackCount(5L);
        this.setDamage(1370.0);
        this.setCooldown(120.0);
        this.setDotDuration(20000L);
        this.setInterval(900L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new SwordOfSoulLightBuff());
    }
}
