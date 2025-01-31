package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ComboAssultBow extends GaugeAttackSkill {
    public ComboAssultBow() {
        this.setName("콤보 어썰트(블래스트, 활대 공격)");
        this.setAttackCount(10L);
        this.setDamage(1854.0);
        this.setCooldown(15.0);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.addFinalDamage(2.2);       // 코어강화
        this.setGaugeCharge(-50.0);
        this.setRelatedSkill(new ComboAssultArrow());
        this.setApplyReuse(true);
    }
}
