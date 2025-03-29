package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ComboAssultArrow extends GaugeAttackSkill {
    public ComboAssultArrow() {
        this.setName("콤보 어썰트(블래스트, 화살 공격)");
        this.setAttackCount(7L);
        this.setDamage(1656.0);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.addFinalDamage(2.2);       // 코어강화
        this.setAddDamage(20L);         // 에인션트 포스-인챈트 인핸스
    }
}
