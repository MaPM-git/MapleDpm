package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Aran extends Job {

    public Aran() {
        // 기본
        super();
        this.setName("아란(0초, 리웨)");
        this.setConstant(1.49);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2808960.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (304 + 187 + 72 + 241));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (304 + 187 + 72 + 241));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);
        
        // 0차
        passive = new Common();
        passive.setDescription("되찾은 기억");
        passive.addAttP(5L);
        getPassiveList().add(passive);
        
        // 1차
        passive = new Common();
        passive.setDescription("폴암 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("페이브");
        passive.addAtt(20L);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("콤보 어빌리티");
        passive.addCriticalP(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("스노우 차지");
        passive.addDamage(15L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("폴암 마스터리");
        passive.addFinalDamage(1.1);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("어드밴스드 콤보 어빌리티");
        passive.addAtt(10L);
        passive.addCriticalDamage(10.0);
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("블레싱 마하");
        passive.addAtt(30L);
        passive.addMagic(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("마이트");
        passive.addAtt(40L);
        passive.addCriticalP(20.0);
        passive.addBossDamage(7L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("하이 마스터리");
        passive.addAtt(20L);
        passive.addCriticalDamage(7.0);
        passive.addFinalDamage(1.21);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("클리빙 어택");
        passive.addDamage(36L);
        passive.addIgnoreDefenseList(41L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(31L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-72L);
        this.addMainStat(-6L);
        this.addSubStat(-10L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("스노우 차지");
        doping.addDamage(10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("하이 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("클리빙 어택(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 파이널 어택(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("블레싱 마하(콜렉터의 영약)");
        doping.addAtt(-30L);
        doping.addMagic(-30L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
