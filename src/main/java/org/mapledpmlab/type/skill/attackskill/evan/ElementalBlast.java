package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.evan.ElementalBlastBuff;

public class ElementalBlast extends AttackSkill {
    public ElementalBlast() {
        this.setName("엘리멘탈 블래스트");
        this.setDamage(1705.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(780L);
        this.setCooldown(40.0);             // 코어 강화
        this.addFinalDamage(1.6);
        this.setRelatedSkill(new ElementalBlastBuff());
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(660L);
        this.getMultiAttackInfo().add(1230L);
        this.getMultiAttackInfo().add(2070L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
